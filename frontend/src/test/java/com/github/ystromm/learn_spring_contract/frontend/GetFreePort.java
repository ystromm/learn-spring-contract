package com.github.ystromm.learn_spring_contract.frontend;

import java.io.IOException;
import java.net.ServerSocket;

public final class GetFreePort {

    static int getFreePort() {
        try (final ServerSocket socket = new ServerSocket(0)) {
            return socket.getLocalPort();

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    // hidden
    private GetFreePort() {
        // empty
    }
}
