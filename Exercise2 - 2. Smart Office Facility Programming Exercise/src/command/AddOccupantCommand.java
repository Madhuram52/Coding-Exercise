package src.command;

import src.service.OccupancyService;

public class AddOccupantCommand implements Command {
    private OccupancyService occupancyService;
    private int roomNumber;
    private int occupantCount;

    public AddOccupantCommand(OccupancyService occupancyService, int roomNumber, int occupantCount) {
        this.occupancyService = occupancyService;
        this.roomNumber = roomNumber;
        this.occupantCount = occupantCount;
    }

    @Override
    public void execute() {
        occupancyService.addOccupant(roomNumber, occupantCount);
    }
}
