package app.phoenixshell.productfinder.lang

suspend fun <T> tryOutcome(callback: suspend () -> T): Outcome<T> {
    return try {
        val result = callback()
        Outcome.Success.wrap(result)
    } catch (e: Exception) {
        Outcome.None.create()
    }
}

sealed interface Outcome<out T> {
    class Success<T> private constructor(val value: T): Outcome<T> {
        companion object {
            fun <T> wrap(value: T?): Outcome<T> {
                return if(value == null) {
                    None.create()
                } else {
                    Success(value)
                }
            }
        }
    }

    class None private constructor(val throwable: Throwable?): Outcome<Nothing> {
        companion object {
            fun create(): None {
                return None(null)
            }
        }
    }
}