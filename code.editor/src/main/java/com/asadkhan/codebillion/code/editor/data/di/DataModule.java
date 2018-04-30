package com.asadkhan.codebillion.code.editor.data.di;

import com.asadkhan.codebillion.code.editor.data.CompilerDataRepository;
import com.asadkhan.codebillion.code.editor.data.CompilerRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Singleton
    @Provides
    public CompilerRepository provideCompilerRepo(CompilerDataRepository repository) {
        return repository;
    }

}
