package com.kennshi.gym_management_web.bootstrap;


import com.kennshi.gym_management_rest.domain.Client;
import com.kennshi.gym_management_rest.domain.Membership;
import com.kennshi.gym_management_rest.domain.MembershipType;
import com.kennshi.gym_management_rest.domain.Visit;
import com.kennshi.gym_management_rest.repositories.ClientRepository;
import com.kennshi.gym_management_rest.repositories.MembershipRepository;
import com.kennshi.gym_management_rest.repositories.MembershipTypeRepository;
import com.kennshi.gym_management_rest.repositories.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final MembershipRepository membershipRepository;
    private final VisitRepository visitRepository;
    private final MembershipTypeRepository membershipTypeRepository;

    public DataLoader(ClientRepository clientRepository, MembershipRepository membershipRepository, VisitRepository visitRepository, MembershipTypeRepository membershipTypeRepository) {
        this.clientRepository = clientRepository;
        this.membershipRepository = membershipRepository;
        this.visitRepository = visitRepository;
        this.membershipTypeRepository = membershipTypeRepository;
    }

    //MEMBERSHIP TYPES
    static final MembershipType yearMembership = new MembershipType("12 MONTHS");
    static final MembershipType threeMonths = new MembershipType("3 MONTHS");
    static final MembershipType oneMonth = new MembershipType("1 MONTH");
    static final MembershipType month12Visits = new MembershipType("12 VISITS");

    @Override
    public void run(String... args) throws Exception {
        //Adding membership types
        membershipTypeRepository.save(yearMembership);
        membershipTypeRepository.save(threeMonths);
        membershipTypeRepository.save(oneMonth);
        membershipTypeRepository.save(month12Visits);

        //loading clients
        Client client1 = new Client();
        client1.setName("Busuioc Eduard");
        client1.setEmail("anymail@gmail.com");
        client1.setBirthday(LocalDate.of(2004, 1, 30));
        client1.setPhone("123456789");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setName("Pohui pohui");
        client2.setEmail("pentrutiemail@gmail.com");
        client2.setBirthday(LocalDate.of(2001, 2, 11));
        client2.setPhone("133769131");
        clientRepository.save(client2);

        //loading memberships
        Membership edwardsMembership = new Membership(client1, yearMembership);
        Membership edwardsMembership1 = new Membership(client1, month12Visits);
        membershipRepository.save(edwardsMembership);
        membershipRepository.save(edwardsMembership1);

        Membership nicoletasMembership = new Membership(client2, month12Visits);
        membershipRepository.save(nicoletasMembership);

        //assigning memberships to clients
        client1.getMemberships().add(edwardsMembership);
        client1.getMemberships().add(edwardsMembership1);
        clientRepository.save(client1);

        client2.getMemberships().add(nicoletasMembership);
        clientRepository.save(client2);

        //loading visits
        Visit visit1 = new Visit(client1);
        Visit visit2 = new Visit(client1);
        visitRepository.save(visit1);
        visitRepository.save(visit2);

        client1.getVisits().add(visit1);
        client1.getVisits().add(visit2);
        clientRepository.save(client1);

        //logging data loader
        log.debug("Memberships loaded: " + membershipRepository.count());
        log.debug("Clients loaded: " + clientRepository.count());
        log.debug("Visits loaded: " + visitRepository.count());
        log.debug("Membership types loaded: " + membershipTypeRepository.count());
    }
}

