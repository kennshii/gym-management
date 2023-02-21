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

import java.math.BigDecimal;
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

    @Override
    public void run(String... args) throws Exception {
        //Adding membership types
        MembershipType yearMembership = MembershipType.builder()
                .name("12 MONTHS")
                .price(BigDecimal.valueOf(2999L))
                .maxVisits(-1)
                .build();
        membershipTypeRepository.save(yearMembership);

        MembershipType threeMonths = MembershipType.builder()
                .name("3 MONTHS")
                .price(BigDecimal.valueOf(999L))
                .maxVisits(-1)
                .build();
        membershipTypeRepository.save(threeMonths);

        MembershipType oneMonth = MembershipType.builder()
                .name("1 MONTH")
                .price(BigDecimal.valueOf(450L))
                .maxVisits(-1)
                .build();
        membershipTypeRepository.save(oneMonth);

        MembershipType month12Visits = MembershipType.builder()
                .name("12 VISITS")
                .price(BigDecimal.valueOf(450L))
                .maxVisits(12)
                .build();
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
        client2.setPhone("068056913");
        clientRepository.save(client2);

        //loading memberships
        Membership edwardsMembership = new Membership(client1, yearMembership);
        membershipRepository.save(edwardsMembership);

        Membership nicoletasMembership = new Membership(client2, month12Visits);
        membershipRepository.save(nicoletasMembership);
        //assigning memberships to clients
        client1.getMemberships().add(edwardsMembership);
        clientRepository.save(client1);

        client2.getMemberships().add(nicoletasMembership);
        clientRepository.save(client2);

        //loading visits
        Visit visit1 = new Visit(client1);
        visitRepository.save(visit1);
        client1.getVisits().add(visit1);
        clientRepository.save(client1);

        //logging data loader
        log.debug("Memberships loaded: " + membershipRepository.count());
        log.debug("Clients loaded: " + clientRepository.count());
        log.debug("Visits loaded: " + visitRepository.count());
        log.debug("Membership types loaded: " + membershipTypeRepository.count());
    }
}

