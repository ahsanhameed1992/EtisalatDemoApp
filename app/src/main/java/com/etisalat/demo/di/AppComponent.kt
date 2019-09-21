package com.etisalat.demo.di

import android.app.Application
import com.etisalat.demo.DemoApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton


@Suppress("unused")
@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (ActivityModule::class),
    (ViewModelModule::class),
    (AppModule::class),
    (RoomModule::class)])
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: DemoApplication): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}
