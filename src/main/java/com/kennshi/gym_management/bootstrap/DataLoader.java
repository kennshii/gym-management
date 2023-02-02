package com.kennshi.gym_management.bootstrap;

import com.kennshi.gym_management.domain.Client;
import com.kennshi.gym_management.domain.Membership;
import com.kennshi.gym_management.domain.MembershipType;
import com.kennshi.gym_management.repositories.ClientRepository;
import com.kennshi.gym_management.repositories.MembershipRepository;
import com.kennshi.gym_management.repositories.MembershipTypeRepository;
import com.kennshi.gym_management.repositories.VisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final MembershipRepository membershipRepository;
    private final VisitRepository visitRepository;
    private final MembershipTypeRepository membershipTypeRepository;

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
        client2.setName("Nicoleta Catruc");
        client2.setEmail("pentrutiemail@gmail.com");
        client2.setBirthday(LocalDate.of(2001, 2, 11));
        client2.setPhone("998844221");
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

        //logging data loader
        log.debug("Memberships loaded: " + membershipRepository.count());
        log.debug("Clients loaded: " + clientRepository.count());
        log.debug("Visits loaded: " + visitRepository.count());
        log.debug("Membership types loaded: " + membershipTypeRepository.count());


    }
}

