/*
 * Copyright 2014-2022 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.server.sessions

internal actual fun platformCache(delegate: SessionStorage, idleTimeout: Long): Cache<String, String> {
    return BaseCache { delegate.read(it) }
}
