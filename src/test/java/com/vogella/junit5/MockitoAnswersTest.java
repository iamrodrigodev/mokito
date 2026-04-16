package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MockitoAnswersTest {
    interface FluentList {
        String add(String value);
    }

    @Test
    void answerTest() {
        FluentList list = mock(FluentList.class);
        doAnswer(returnsFirstArg()).when(list).add(anyString());
        when(list.add(anyString())).thenAnswer(returnsFirstArg());

        assertEquals("hello", list.add("hello"));
    }

    @Test
    void callbackTest() {
        ApiService service = mock(ApiService.class);
        final String[] message = {null};

        when(service.login(any(Callback.class))).thenAnswer(i -> {
            Callback callback = i.getArgument(0);
            callback.onSuccess("Success");
            return null;
        });

        service.login(new Callback() {
            @Override
            public void onSuccess(String msg) {
                message[0] = msg;
            }

            @Override
            public void onFailure(String error) {
                message[0] = error;
            }
        });

        assertEquals("Success", message[0]);
    }

    @Test
    void daoAnswerTest() {
        List<User> userMap = new ArrayList<>();
        UserDao dao = mock(UserDao.class);

        doAnswer(i -> {
            User user = i.getArgument(0);
            userMap.add(user);
            return null;
        }).when(dao).save(any(User.class));
        when(dao.find(anyInt())).thenAnswer(i -> {
            int id = i.getArgument(0);
            return userMap.get(id);
        });

        User user = new User("a@a.com", "A");
        dao.save(user);
        dao.save(new User("b@b.com", "B"));

        assertEquals("A", dao.find(0).getName());
        assertEquals("B", dao.find(1).getName());
    }
}
