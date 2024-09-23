package src.command;

import src.config.OfficeConfig;

public class ConfigRoomCommand implements Command {
    private OfficeConfig officeConfig;
    private int roomCount;
    private int roomNumber;
    private int capacity;
    private boolean isSettingCount;

    public ConfigRoomCommand(OfficeConfig officeConfig, int roomCount) {
        this.officeConfig = officeConfig;
        this.roomCount = roomCount;
        this.isSettingCount = true;
    }

    public ConfigRoomCommand(OfficeConfig officeConfig, int roomNumber, int capacity) {
        this.officeConfig = officeConfig;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.isSettingCount = false;
    }

    @Override
    public void execute() {
        if (isSettingCount) {
            officeConfig.setRoomCount(roomCount);
            System.out.println("Office configured with " + roomCount + " meeting rooms.");
        } else {
            try {
                officeConfig.setRoomCapacity(roomNumber, capacity);
                System.out.println("Room " + roomNumber + " maximum capacity set to " + capacity + ".");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
