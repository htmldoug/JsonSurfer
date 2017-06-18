/*
 * The MIT License
 *
 * Copyright (c) 2017 WANG Lingsong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.jsfr.json.provider;

import org.jsfr.json.resolver.DocumentResolver;

/**
 * Stateless facade that converts json tokens to some AST.
 *
 * @param <O> object type
 * @param <A> array type
 * @param <P> primitive type
 */
public interface JsonProvider<O, A, P> extends DocumentResolver<O, A> {

    /**
     * @return new empty object
     */
    O createObject();

    /**
     * @return new empty array
     */
    A createArray();

    /**
     * Appends the key-value pair to the object
     */
    void put(O object, String key, P value);

    /**
     * Appends the value to the array
     */
    void add(A array, P value);

    P primitive(boolean value);

    P primitive(int value);

    P primitive(double value);

    P primitive(long value);

    P primitive(String value);

    P primitiveNull();

    <T> T cast(P value, Class<T> tClass);

}
