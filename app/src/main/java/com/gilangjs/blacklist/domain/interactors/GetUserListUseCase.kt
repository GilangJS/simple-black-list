package com.gilangjs.blacklist.domain.interactors

import com.gilangjs.blacklist.domain.model.User
import com.gilangjs.blacklist.domain.repositorycontract.IUserRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(
    private val userRepository: IUserRepository
): UseCase<Unit, List<User>>() {

    override suspend fun run(params: Unit, scope: CoroutineScope): Result<List<User>> =
        userRepository.getUsers()
}
