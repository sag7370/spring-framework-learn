/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.orm.jpa;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link SharedEntityManagerCreator}.
 * 
 * @author Oliver Gierke
 */
@RunWith(MockitoJUnitRunner.class)
public class SharedEntityManagerCreatorTests {

	@Mock
	MyEntityManagerFactory info;

	@Test
	public void proxyingWorksIfInfoReturnsNullEntityManagerInterface() {

		when(info.getEntityManagerInterface()).thenReturn(null);
		assertThat(SharedEntityManagerCreator.createSharedEntityManager(info),
				is(notNullValue()));
	}

	interface MyEntityManagerFactory extends EntityManagerFactory,
			EntityManagerFactoryInfo {

	}
}
