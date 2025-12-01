package de.seuhd.campuscoffee.tests.system;

import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.tests.TestFixtures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static de.seuhd.campuscoffee.tests.SystemTestUtils.Requests.userRequests;

public class UsersSystemTests extends AbstractSysTest {

    @Test
    void createUser() {
        User userToCreate = TestFixtures.getUserListForInsertion().getFirst();
        User createdUser = userDtoMapper.toDomain(userRequests.create(List.of(userDtoMapper.fromDomain(userToCreate))).getFirst());

        assertEqualsIgnoringIdAndTimestamps(createdUser, userToCreate);
    }

    @Test
    void deleteUser() {
        TestFixtures.createUsers(userService);
        User userToDelete = TestFixtures.getUserList().getFirst();
        Integer statusCode = userRequests.deleteAndReturnStatusCodes(List.of(Objects.requireNonNull(userDtoMapper.fromDomain(userToDelete).id()))).getFirst();

        Assertions.assertEquals(204, statusCode);
    }
}