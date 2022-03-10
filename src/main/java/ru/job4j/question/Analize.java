package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Map previousMap = previous.stream().collect(Collectors.toMap(User::getId, user -> user));
        Map currentMap = current.stream().collect(Collectors.toMap(User::getId, user -> user));
        Info info = new Info(0, 0, 0);
        for (User user : current) {
            if (!previousMap.containsKey(user.getId())) { /*добавленный*/
                info.setAdded(info.getAdded() + 1);
            }
            if (previousMap.containsKey(user.getId()) && !previous.contains(user)) { /*измененный*/
                info.setChanged(info.getChanged() + 1);
            }
        }
        for (User user : previous) {
            if (!currentMap.containsKey(user.getId())) { /*удаленный*/
                info.setDeleted(info.getDeleted() + 1);
            }
        }
        return new Info(info.getAdded(), info.getChanged(), info.getDeleted());
    }
}
