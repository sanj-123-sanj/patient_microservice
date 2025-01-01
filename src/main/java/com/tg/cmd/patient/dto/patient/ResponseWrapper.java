package com.tg.cmd.patient.dto.patient;

/**
 * A generic wrapper class to standardize API responses.
 *
 * @param <T> The type of the data being wrapped in the response.
 */
public class ResponseWrapper<T> {
    private String message; // Message describing the status or outcome of the response
    private T data; // Generic data object to hold any type of response data

    /**
     * Constructor to create a ResponseWrapper with a message only.
     * 
     * @param message The message describing the response status or outcome.
     */
    public ResponseWrapper(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.message = message;
    }

    /**
     * Constructor to create a ResponseWrapper with both a message and data.
     * 
     * @param message The message describing the response status or outcome.
     * @param data The data object containing the response payload.
     */
    public ResponseWrapper(String message, T data) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.message = message;
        this.data = data;
    }

    /**
     * Gets the message describing the response.
     * 
     * @return The response message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message describing the response.
     * 
     * @param message The response message to set.
     */
    public void setMessage(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.message = message;
    }

    /**
     * Gets the data object containing the response payload.
     * 
     * @return The response data.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data object containing the response payload.
     * 
     * @param data The response data to set.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Provides a string representation of the ResponseWrapper object.
     * 
     * @return A string representation of the response.
     */
    @Override
    public String toString() {
        return "ResponseWrapper{" +
                "message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * Checks equality of two ResponseWrapper objects.
     * 
     * @param obj The object to compare to.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ResponseWrapper<?> that = (ResponseWrapper<?>) obj;
        return message.equals(that.message) && data.equals(that.data);
    }

    /**
     * Generates a hash code for the ResponseWrapper object.
     * 
     * @return A hash code for the object.
     */
    @Override
    public int hashCode() {
        return 31 * message.hashCode() + (data != null ? data.hashCode() : 0);
    }
}
