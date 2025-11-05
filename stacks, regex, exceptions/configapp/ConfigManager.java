package SU3.configapp;

import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private final List<ConfigUnit> configs;
    private int nextId = 1;

    public ConfigManager() {
        this.configs = new ArrayList<>();
    }

    public void addConfig(String key, String value) {
        ConfigUnit config = new ConfigUnit(nextId++, key, value);
        configs.add(config);
    }

    public boolean editConfig(int id, String newKey, String newValue) {
        for (ConfigUnit c : configs) {
            if (c.getId() == id) {
                c.setKey(newKey);
                c.setValue(newValue);
                return true;
            }
        }
        return false;
    }

    public List<ConfigUnit> getAllConfigs() {
        return configs;
    }

    public boolean isEmpty() {
        return configs.isEmpty();
    }
}

