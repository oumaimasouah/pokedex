package com.skydoves.core.data.repository

import androidx.annotation.WorkerThread
import com.skydoves.pokedex.core.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface MainRepository {

  @WorkerThread
  fun fetchPokemonList(
    page: Int,
    onStart: () -> Unit,
    onComplete: () -> Unit,
    onError: (String?) -> Unit
  ): Flow<List<Pokemon>>
}
