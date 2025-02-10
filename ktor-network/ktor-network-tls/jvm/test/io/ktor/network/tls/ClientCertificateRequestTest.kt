/*
 * Copyright 2014-2023 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.network.tls

import io.ktor.utils.io.core.*
import kotlin.test.*

class ClientCertificateRequestTest {
    @Test
    fun `request with specific authorities`() {
        val bytes = arrayOf<Byte>(
            3, 1, 2, 64, 0, 46, 4, 3, 5, 3, 6, 3, 8, 7, 8, 8, 8, 9, 8, 10, 8, 11, 8, 4, 8, 5, 8, 6, 4, 1, 5, 1,
            6, 1, 3, 3, 2, 3, 3, 1, 2, 1, 3, 2, 2, 2, 4, 2, 5, 2, 6, 2, 1, -47, 0, 91, 48, 89, 49, 19, 48, 17,
            6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 99, 111, 109, 49, 19, 48, 17, 6, 10, 9,
            -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 118, 119, 103, 49, 21, 48, 19, 6, 10, 9, -110,
            38, -119, -109, -14, 44, 100, 1, 25, 22, 5, 86, 87, 80, 75, 73, 49, 22, 48, 20, 6, 3, 85, 4, 3,
            19, 13, 86, 87, 45, 67, 65, 45, 79, 84, 72, 82, 45, 48, 57, 0, 91, 48, 89, 49, 19, 48, 17, 6, 10,
            9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 99, 111, 109, 49, 19, 48, 17, 6, 10, 9, -110,
            38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 118, 119, 103, 49, 21, 48, 19, 6, 10, 9, -110, 38, -119,
            -109, -14, 44, 100, 1, 25, 22, 5, 86, 87, 80, 75, 73, 49, 22, 48, 20, 6, 3, 85, 4, 3, 19, 13, 86, 87,
            45, 67, 65, 45, 79, 84, 72, 82, 45, 49, 48, 0, 91, 48, 89, 49, 19, 48, 17, 6, 10, 9, -110, 38, -119,
            -109, -14, 44, 100, 1, 25, 22, 3, 99, 111, 109, 49, 19, 48, 17, 6, 10, 9, -110, 38, -119, -109, -14,
            44, 100, 1, 25, 22, 3, 118, 119, 103, 49, 21, 48, 19, 6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1,
            25, 22, 5, 86, 87, 80, 75, 73, 49, 22, 48, 20, 6, 3, 85, 4, 3, 19, 13, 86, 87, 45, 67, 65, 45, 80, 82,
            79, 67, 45, 48, 55, 0, 91, 48, 89, 49, 19, 48, 17, 6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25,
            22, 3, 99, 111, 109, 49, 19, 48, 17, 6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 118,
            119, 103, 49, 21, 48, 19, 6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 5, 86, 87, 80, 75,
            73, 49, 22, 48, 20, 6, 3, 85, 4, 3, 19, 13, 86, 87, 45, 67, 65, 45, 80, 82, 79, 67, 45, 48, 56, 0, 91,
            48, 89, 49, 19, 48, 17, 6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 99, 111, 109, 49,
            19, 48, 17, 6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 3, 118, 119, 103, 49, 21, 48, 19,
            6, 10, 9, -110, 38, -119, -109, -14, 44, 100, 1, 25, 22, 5, 86, 87, 80, 75, 73, 49, 22, 48, 20, 6, 3,
            85, 4, 3, 19, 13, 86, 87, 45, 67, 65, 45, 82, 79, 79, 84, 45, 48, 53
        ).toByteArray()
        val packet = ByteReadPacket(bytes)
        val certInfo = readClientCertificateRequest(packet)
        assertEquals(5, certInfo.authorities.size)
    }
}
