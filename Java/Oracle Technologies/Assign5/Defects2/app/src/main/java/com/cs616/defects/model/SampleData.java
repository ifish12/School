package com.cs616.defects.model;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ian on 15-10-25.
 */
public class SampleData {

    private CRUDRepository<Long, User> userRepository;
    private CRUDRepository<Long, Defect> defectRepository;

    public SampleData(CRUDRepository<Long, User> userRepository, CRUDRepository<Long, Defect> defectRepository) {
        this.userRepository = userRepository;
        this.defectRepository = defectRepository;
    }

    public void populate() throws IOException {

        User testerTim = new User("Tim Trotter", UserType.TESTER, null);
        User testerTara = new User("Tara Tutu", UserType.TESTER, null);
        User developerDeborah = new User("Deborah Denton", UserType.DEVELOPER, null);
        User developerDarren = new User("Darren Dahlia", UserType.DEVELOPER, null);
        User managerMary = new User("Mary Malcop", UserType.MANAGER, null);
        User customerColin = new User("Colin Carton", UserType.CUSTOMER, null);





        userRepository.create(testerTim);
        userRepository.create(testerTara);
        userRepository.create(developerDarren);
        userRepository.create(developerDeborah);
        userRepository.create(managerMary);
        userRepository.create(customerColin);


        defectRepository.create(new Defect()
                .setCreated(may(1))
                .setCreatedBy(testerTim)
                .setSummary("MP3 files crash system")
                .setSeverity(Severity.SHOWSTOPPER)
                .setAssignedTo(developerDarren)
                .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                .setModified(may(23))
                );

        defectRepository.create(new Defect()
                        .setCreated(may(3))
                        .setCreatedBy(developerDeborah)
                        .setSummary("Text is too big")
                        .setSeverity(Severity.TRIVIAL)
                        .setStatus(com.cs616.defects.model.Status.CLOSED)
                        .setModified(may(9))
        );

                defectRepository.create(new Defect()
                        .setCreated(may(3))
                        .setCreatedBy(customerColin)
                        .setSummary("Sky is wrong shade of blue")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(testerTara)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(19))
                        );

        defectRepository.create(new Defect()
                        .setCreated(may(4))
                        .setCreatedBy(developerDarren)
                        .setSummary("Can't play files more than 200 bytes long")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.REOPENED)
                        .setModified(may(23))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(6))
                        .setCreatedBy(testerTim)
                        .setSummary("Installation is slow")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(testerTim)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(15))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(7))
                        .setCreatedBy(managerMary)
                        .setSummary("DivX is choppy on Pentium 100")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(29))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(8))
                        .setCreatedBy(developerDeborah)
                        .setSummary("Client acts as virus")
                        .setSeverity(Severity.SHOWSTOPPER)
                        .setAssignedTo(null)
                        .setStatus(com.cs616.defects.model.Status.CLOSED)
                        .setModified(may(10))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(8))
                        .setCreatedBy(developerDarren)
                        .setSummary("Subtitles only work in Welsh")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(testerTim)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(23))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(9))
                        .setCreatedBy(customerColin)
                        .setSummary("Voice recognition is confused by background noise")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(null)
                        .setStatus(com.cs616.defects.model.Status.CLOSED)
                        .setModified(may(15))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(9, 10, 34))
                        .setCreatedBy(testerTim)
                        .setSummary("User interface should be more caramelly")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(9, 12, 56))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(10))
                        .setCreatedBy(managerMary)
                        .setSummary("Burning a CD makes the printer catch fire")
                        .setSeverity(Severity.SHOWSTOPPER)
                        .setAssignedTo(null)
                        .setStatus(com.cs616.defects.model.Status.CLOSED)
                        .setModified(may(29))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(10))
                        .setCreatedBy(testerTara)
                        .setSummary("Peer to peer pairing passes parameters poorly")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(12))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(11))
                        .setCreatedBy(developerDarren)
                        .setSummary("Delay when sending message")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(testerTara)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(20))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(11, 13, 45))
                        .setCreatedBy(managerMary)
                        .setSummary("Volume control needs to go to 11")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(11, 15, 15))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(11))
                        .setCreatedBy(customerColin)
                        .setSummary("Splash screen fades too quickly")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(testerTara)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(15))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(12, 17, 23))
                        .setCreatedBy(developerDeborah)
                        .setSummary("Text box doesn't keep up with fast typing")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(12, 18, 54))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(12))
                        .setCreatedBy(developerDarren)
                        .setSummary("Password displayed in plain text")
                        .setSeverity(Severity.SHOWSTOPPER)
                        .setAssignedTo(null)
                        .setStatus(com.cs616.defects.model.Status.CLOSED)
                        .setModified(may(13))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(12))
                        .setCreatedBy(testerTim)
                        .setSummary("Play button points the wrong way")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(testerTim)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(17))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(13))
                        .setCreatedBy(customerColin)
                        .setSummary("Wizard needed for CD burning")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(customerColin)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(20))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(13))
                        .setCreatedBy(managerMary)
                        .setSummary("Subtitles don't display during fast forward")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(14))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(13, 9, 34))
                        .setCreatedBy(developerDarren)
                        .setSummary("Memory leak when watching Memento")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(13,12,34))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(13))
                        .setCreatedBy(developerDeborah)
                        .setSummary("Profile screen shows login count of -1")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(20))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(13))
                        .setCreatedBy(testerTim)
                        .setSummary("Server crashes under heavy load (3 users)")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(17))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(15))
                        .setCreatedBy(testerTara)
                        .setSummary("Unable to connect to any media server")
                        .setSeverity(Severity.SHOWSTOPPER)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.REOPENED)
                        .setModified(may(18))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(15))
                        .setCreatedBy(developerDeborah)
                        .setSummary("UI turns black and white when playing old films")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(testerTara)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(25))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(16))
                        .setCreatedBy(managerMary)
                        .setSummary("Password reset changes passwords for all users")
                        .setSeverity(Severity.SHOWSTOPPER)
                        .setAssignedTo(null)
                        .setStatus(com.cs616.defects.model.Status.CLOSED)
                        .setModified(may(18))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(17))
                        .setCreatedBy(testerTim)
                        .setSummary("Modern music sounds rubbish")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(17, 5, 32))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(18))
                        .setCreatedBy(testerTim)
                        .setSummary("Webcam makes me look bald")
                        .setSeverity(Severity.SHOWSTOPPER)
                        .setAssignedTo(testerTim)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(27))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(18, 23, 23))
                        .setCreatedBy(customerColin)
                        .setSummary("Sound is distorted when speakers are underwater")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(18,23,45))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(19))
                        .setCreatedBy(developerDarren)
                        .setSummary("Japanese characters don't display properly")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(23))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(20))
                        .setCreatedBy(testerTara)
                        .setSummary("Video takes 100% of CPU")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(22))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(22))
                        .setCreatedBy(testerTim)
                        .setSummary("DVD Easter eggs unavailable")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(22, 12,12))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(23))
                        .setCreatedBy(managerMary)
                        .setSummary("Transparency is high for menus to be readable")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(25))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(24))
                        .setCreatedBy(customerColin)
                        .setSummary("About box is missing version number")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(customerColin)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(29))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(25))
                        .setCreatedBy(testerTim)
                        .setSummary("Logs record confidential conversations")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.REOPENED)
                        .setModified(may(30))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(27))
                        .setCreatedBy(developerDeborah)
                        .setSummary("Profanity filter is too aggressive")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(testerTara)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(29))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(27, 8, 56))
                        .setCreatedBy(testerTara)
                        .setSummary("Full screen mode fails on dual monitors")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(27, 10, 12))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(28))
                        .setCreatedBy(customerColin)
                        .setSummary("Visualization hypnotises pets")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(developerDeborah)
                        .setStatus(com.cs616.defects.model.Status.ACCEPTED)
                        .setModified(may(29))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(28))
                        .setCreatedBy(managerMary)
                        .setSummary("Resizing while typing loses input")
                        .setSeverity(Severity.TRIVIAL)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(29))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(30))
                        .setCreatedBy(testerTim)
                        .setSummary("Network is saturated when playing WAV file")
                        .setSeverity(Severity.MINOR)
                        .setAssignedTo(testerTim)
                        .setStatus(com.cs616.defects.model.Status.FIXED)
                        .setModified(may(31))
        );

        defectRepository.create(new Defect()
                        .setCreated(may(30))
                        .setCreatedBy(testerTara)
                        .setSummary("Media library tells user to keep the noise down")
                        .setSeverity(Severity.MAJOR)
                        .setAssignedTo(developerDarren)
                        .setStatus(com.cs616.defects.model.Status.CREATED)
                        .setModified(may(31))
        );


    }

    private static Date may(int day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse("2015-5-" + String.valueOf(day));
        } catch (ParseException e) {
            return null;
        }
    }

    private static Date may(int day, int hour, int min) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            return format.parse("2015-5-" + String.valueOf(day) + " " + String.valueOf(hour) + ":" + String.valueOf(min));
        } catch (ParseException e) {
            return null;
        }
    }
}
