/*
 * Copyright 2002-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.transaction.interceptor;

import java.io.Serializable;
import java.lang.reflect.Method;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.lang.Nullable;
import org.springframework.transaction.TransactionManager;
import org.springframework.util.ObjectUtils;

/**
 * Abstract class that implements a Pointcut that matches if the underlying
 * {@link TransactionAttributeSource} has an attribute for a given method.
 *
 * @author Juergen Hoeller
 * @since 2.5.5
 */
@SuppressWarnings("serial")
// 首先它的访问权限事default 显示是给内部使用的
// 首先它继承自StaticMethodMatcherPointcut   所以`ClassFilter classFilter = ClassFilter.TRUE;` 匹配所有的类
// 并且isRuntime=false  表示只需要对方法进行静态匹配即可~~~~
abstract class TransactionAttributeSourcePointcut extends StaticMethodMatcherPointcut implements Serializable {

	protected TransactionAttributeSourcePointcut() {
		setClassFilter(new TransactionAttributeSourceClassFilter());
	}
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		TransactionAttributeSource tas = getTransactionAttributeSource();
		return (tas == null || tas.getTransactionAttribute(method, targetClass) != null);
	}

	@Override
	public boolean equals(@Nullable Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TransactionAttributeSourcePointcut)) {
			return false;
		}
		TransactionAttributeSourcePointcut otherPc = (TransactionAttributeSourcePointcut) other;
		return ObjectUtils.nullSafeEquals(getTransactionAttributeSource(), otherPc.getTransactionAttributeSource());
	}

	@Override
	public int hashCode() {
		return TransactionAttributeSourcePointcut.class.hashCode();
	}

	@Override
	public String toString() {
		return getClass().getName() + ": " + getTransactionAttributeSource();
	}


	/**
	 * Obtain the underlying TransactionAttributeSource (may be {@code null}).
	 * To be implemented by subclasses.
	 */
	// 由子类提供给我，告诉事务属性源~~~~ 我才好知道哪些方法我需要切嘛~~~
	@Nullable
	protected abstract TransactionAttributeSource getTransactionAttributeSource();


	/**
	 * {@link ClassFilter} that delegates to {@link TransactionAttributeSource#isCandidateClass}
	 * for filtering classes whose methods are not worth searching to begin with.
	 */
	private class TransactionAttributeSourceClassFilter implements ClassFilter {

		// 方法的匹配  静态匹配即可（因为事务无需要动态匹配这么细粒度~~~）
		@Override
		public boolean matches(Class<?> clazz) {
			// 实现了如下三个接口的子类，就不需要被代理了  直接放行
			// TransactionalProxy它是SpringProxy的子类。  如果是被TransactionProxyFactoryBean生产出来的Bean，就会自动实现此接口，那么就不会被这里再次代理了
			// PlatformTransactionManager：spring抽象的事务管理器~~~
			// PersistenceExceptionTranslator对RuntimeException转换成DataAccessException的转换接口
			if (TransactionalProxy.class.isAssignableFrom(clazz) ||
					TransactionManager.class.isAssignableFrom(clazz) ||
					PersistenceExceptionTranslator.class.isAssignableFrom(clazz)) {
				return false;
			}
			// 重要：拿到事务属性源~~~~~~
			// 如果tas == null表示没有配置事务属性源，那是全部匹配的  也就是说所有的方法都匹配~~~~（这个处理还是比较让我诧异的~~~）
			// 或者 标注了@Transaction这样的注解的方法才会给与匹配~~~
			TransactionAttributeSource tas = getTransactionAttributeSource();
			return (tas == null || tas.isCandidateClass(clazz));
		}
	}

}
