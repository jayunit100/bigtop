/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.bigtop.bigpetstore.datagenerator;

import java.util.Collection;

import org.apache.bigtop.bigpetstore.datagenerator.datamodels.Customer;
import org.apache.bigtop.bigpetstore.datagenerator.datamodels.Transaction;
import org.apache.bigtop.bigpetstore.datagenerator.datamodels.inputs.ProductCategory;
import org.apache.bigtop.bigpetstore.datagenerator.framework.SeedFactory;
import org.apache.bigtop.bigpetstore.datagenerator.framework.samplers.Sampler;
import org.apache.bigtop.bigpetstore.datagenerator.generators.purchase.PurchasingModel;
import org.apache.bigtop.bigpetstore.datagenerator.generators.transaction.TransactionSamplerBuilder;

public class TransactionGenerator
{
	Sampler<Transaction> sampler;
	
	public TransactionGenerator(Customer customer, PurchasingModel profile, 
			Collection<ProductCategory> productCategories, SeedFactory seedFactory) throws Exception
	{
		sampler = new TransactionSamplerBuilder(productCategories,
				customer, profile, seedFactory).build();
	}
	
	public Transaction generate() throws Exception
	{
		return sampler.sample();
	}
}
