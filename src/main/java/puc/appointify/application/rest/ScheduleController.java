package puc.appointify.application.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import puc.appointify.domain.ports.in.schedules.ScheduleQueryHandler;
import puc.appointify.domain.ports.in.schedules.SchedulesCommandHandler;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommand;
import puc.appointify.domain.ports.in.schedules.contract.command.CreateScheduleCommandResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindAvailableSchedulesQuery;
import puc.appointify.domain.ports.in.schedules.contract.query.FindAvailableSchedulesQueryResponse;
import puc.appointify.domain.ports.in.schedules.contract.query.FindScheduleQueryResponse;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final SchedulesCommandHandler schedulesCommandHandler;
    private final ScheduleQueryHandler scheduleQueryHandler;

    @GetMapping
    public ResponseEntity<List<FindScheduleQueryResponse>> findAll() {
        return ResponseEntity.ok()
                .body(scheduleQueryHandler.findAll());
    }

    @GetMapping("/available")
    public ResponseEntity<List<FindAvailableSchedulesQueryResponse>> findAvailability(
            @RequestParam UUID companyId,
            @RequestParam UUID offeredServiceId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rangeStartDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date rangeEndDate
    ) {
        return ResponseEntity.ok()
                .body(scheduleQueryHandler.find(FindAvailableSchedulesQuery
                        .builder()
                        .companyId(companyId)
                        .offeredServiceId(offeredServiceId)
                        .rangeStartDate(rangeStartDate)
                        .rangeEndDate(rangeEndDate)
                        .build()));
    }

    @PostMapping
    public ResponseEntity<CreateScheduleCommandResponse> create(
            @RequestBody @Valid CreateScheduleCommand command) {
        return ResponseEntity.ok()
                .body(schedulesCommandHandler.create(command));
    }

}
