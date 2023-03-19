package com.skydoves.core.data.repository

import androidx.annotation.WorkerThread
import com.skydoves.pokedex.core.model.PokemonInfo
import kotlinx.coroutines.flow.Flow

interface DetailRepository {

  @WorkerThread
  fun fetchPokemonInfo(
    name: String,
    onComplete: () -> Unit,
    onError: (String?) -> Unit
  ): Flow<PokemonInfo>
}
