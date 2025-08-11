sealed class Operation {
    data class Success(val msg: Any): Operation()
    data class Loading(val msg: String): Operation()
    data class Error(val msg: String): Operation()
    data class LockedAccount(val msg: String): Operation()
}