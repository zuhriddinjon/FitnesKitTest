package uz.instat.fitneskittest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.instat.fitneskittest.busines.network.abstraction.MainService
import uz.instat.fitneskittest.busines.network.implementation.MainServiceImpl
import uz.instat.fitneskittest.framework.MainRepo
import uz.instat.fitneskittest.framework.MainRepoImpl
import uz.instat.fitneskittest.framework.datasource.MainDataSource
import uz.instat.fitneskittest.framework.datasource.MainDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModuleBinds {


    @Singleton
    @Binds
    abstract fun bindMainRepository(mainRepositoryImpl: MainRepoImpl): MainRepo


    @Singleton
    @Binds
    abstract fun bindMainService(mainServiceImpl: MainServiceImpl): MainService


    @Singleton
    @Binds
    abstract fun bindMainDataSource(mainDataSourceImpl: MainDataSourceImpl): MainDataSource

}