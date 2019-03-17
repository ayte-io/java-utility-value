/**
 * <p>
 * This package contains interfaces for value classes - Pair, Trio and
 * Quad, and their extended counterversions AmplePair, AmpleTrio and
 * AmpleQuad.
 * </p>
 *
 * <p>
 * Regular interfaces just expose getters, while Ample interfaces have
 * additional functionality:
 * </p>
 *
 * <ul>
 *     <li>
 *         regular setters that set value in-place or return completely
 *         new instance depending on whether implementation is immutable
 *     </li>
 *     <li>
 *         {@code withX()} methods that allow to get copy of container
 *         with selected value replaced by value of another type
 *     </li>
 *     <li>
 *         {@code rollForward()} method that will set latest value as
 *         first, first as second, and so on, and {@code rollBackward}
 *         method that does the opposite.
 *     </li>
 *     <li>
 *         {@code reverse()} method that will return new instance with
 *         value in inverse order
 *     </li>
 *     <li>
 *         {@code stream()} method that will turn container into single
 *         item stream
 *     </li>
 * </ul>
 */
package io.ayte.utility.value.api;
