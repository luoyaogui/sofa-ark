/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.ark.container.guice;

import com.alipay.sofa.ark.common.guice.AbstractArkGuiceModule;
import com.alipay.sofa.ark.container.service.biz.BizManagerServiceImpl;
import com.alipay.sofa.ark.container.service.plugin.PluginManagerServiceImpl;
import com.alipay.sofa.ark.container.pipeline.StandardPipeline;
import com.alipay.sofa.ark.container.service.classloader.ClassloaderServiceImpl;
import com.alipay.sofa.ark.container.service.plugin.PluginDeployServiceImpl;
import com.alipay.sofa.ark.container.service.registry.RegistryServiceImpl;
import com.alipay.sofa.ark.spi.service.biz.BizManagerService;
import com.alipay.sofa.ark.spi.service.plugin.PluginManagerService;
import com.alipay.sofa.ark.spi.pipeline.Pipeline;
import com.alipay.sofa.ark.spi.service.ArkService;
import com.alipay.sofa.ark.spi.service.classloader.ClassloaderService;
import com.alipay.sofa.ark.spi.service.plugin.PluginDeployService;
import com.alipay.sofa.ark.spi.service.registry.RegistryService;
import com.google.inject.multibindings.Multibinder;

/**
 * Guice module for ark container
 *
 * @author ruoshan
 * @since 0.1.0
 */
public class ContainerModule extends AbstractArkGuiceModule {

    @Override
    protected void configure() {
        Multibinder<ArkService> arkServiceMultibinder = Multibinder.newSetBinder(binder(),
            ArkService.class);
        arkServiceMultibinder.addBinding().to(PluginDeployServiceImpl.class);
        arkServiceMultibinder.addBinding().to(ClassloaderServiceImpl.class);

        binder().bind(Pipeline.class).to(StandardPipeline.class);

        binder().bind(PluginManagerService.class).to(PluginManagerServiceImpl.class);
        binder().bind(BizManagerService.class).to(BizManagerServiceImpl.class);
        binder().bind(ClassloaderService.class).to(ClassloaderServiceImpl.class);
        binder().bind(PluginDeployService.class).to(PluginDeployServiceImpl.class);
        binder().bind(RegistryService.class).to(RegistryServiceImpl.class);
    }
}