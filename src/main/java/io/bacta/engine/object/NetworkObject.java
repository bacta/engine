/*
 * Copyright 2017. Bacta
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package io.bacta.engine.object;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by kburkhardt on 2/23/14.
 */

public abstract class NetworkObject implements Comparable<NetworkObject> {
    public static final long INVALID = 0;

    @Getter @Setter
    protected long networkId;

    @Getter @Setter
    protected transient boolean dirty = false;

    @Override
    public final int compareTo(NetworkObject o) {
        if(o.networkId == networkId) {
            return 0;
        }

        if(networkId > o.networkId) {
            return -1;
        }

        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NetworkObject)) return false;

        NetworkObject that = (NetworkObject) o;

        if (networkId != that.networkId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (networkId ^ (networkId >>> 32));
    }
}
