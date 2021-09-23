package com.github.fabriciolfj.consignado.gateway.provider.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Slf4j
@Component
public class InssLegacyProvider {

    public void execute() {
        if (isNotWeekend() && isScheduleValid()) {
            log.info("Processing legacy inss");
            return;
        }

        log.info("Processing hours invalid legacy inss");
    }

    private boolean isNotWeekend() {
        return LocalDateTime.now().getDayOfWeek() != DayOfWeek.SUNDAY && LocalDateTime.now().getDayOfWeek() != DayOfWeek.SATURDAY;
    }

    private boolean isScheduleValid() {
        final LocalTime timeInit = LocalTime.of(07, 00);
        final LocalTime timeLast = LocalTime.of(17, 00);
        return LocalTime.now().isAfter(timeInit) && LocalTime.now().isBefore(timeLast);
    }
}
