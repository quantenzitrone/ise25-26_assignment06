package de.seuhd.campuscoffee.domain.model;

import lombok.Builder;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
/**
 * Domain record that stores the User metadata.
 * This is an immutable value object - use the builder or toBuilder() to create modified copies.
 * Records provide automatic implementations of equals(), hashCode(), toString(), and accessors.
 * <p>
 * We validate the fields in the API layer based on the DTOs, so no validation annotations are needed here.
 *
 * @param id           the unique identifier; null when the User has not been created yet
 * @param createdAt    timestamp set on User creation
 * @param updatedAt    timestamp set on User creation and update
 * @param loginName    the login name of the User
 * @param firstName    the first name of the User
 * @param lastName     the last name of the User
 * @param emailAddress the e-mail address of the User
 */
@Builder(toBuilder = true)
public record User (
        @Nullable Long id, // null when the User has not been created yet
        @Nullable LocalDateTime createdAt, // set on User creation
        @Nullable LocalDateTime updatedAt, // set on User creation and update
        @NonNull String loginName,
        @NonNull String firstName,
        @NonNull String lastName,
        @NonNull String emailAddress
) implements Serializable { // serializable to allow cloning (see TestFixtures class).
    @Serial
    private static final long serialVersionUID = 1L;
}
