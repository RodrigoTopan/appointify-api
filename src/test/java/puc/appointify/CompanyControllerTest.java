package puc.appointify;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import puc.appointify.annotation.UnitTest;
import puc.appointify.application.rest.CompanyController;
import puc.appointify.domain.core.ports.in.company.CompanyCommandHandler;
import puc.appointify.domain.core.ports.in.company.CompanyQueryHandler;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommand;
import puc.appointify.domain.core.ports.in.company.contract.command.CreateCompanyCommandResponse;
import puc.appointify.domain.core.ports.in.company.contract.query.FindCompanyQueryResponse;
import puc.appointify.domain.core.ports.in.offeredservice.OfferedServiceQueryHandler;
import puc.appointify.domain.core.ports.in.offeredservice.contract.query.FindCompanyOfferedServicesQuery;
import puc.appointify.domain.core.ports.in.offeredservice.contract.query.FindOfferedServiceQueryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@UnitTest
public class CompanyControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CompanyCommandHandler companyCommandHandler;

    @Mock
    private CompanyQueryHandler companyQueryHandler;

    @Mock
    private OfferedServiceQueryHandler offeredServiceQueryHandler;

    @InjectMocks
    private CompanyController companyController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    public void testFindAll() throws Exception {
        // Mock data
        List<FindCompanyQueryResponse> companies = new ArrayList<>();
        companies.add(new FindCompanyQueryResponse());
        companies.add(new FindCompanyQueryResponse());

        // Mock behavior
        Mockito.when(companyQueryHandler.findAll()).thenReturn(companies);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/companies"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }

    @Test
    public void testFindById() throws Exception {
        // Mock data
        UUID companyId = UUID.randomUUID();
        FindCompanyQueryResponse company = new FindCompanyQueryResponse();

        // Mock behavior
        Mockito.when(companyQueryHandler.findById(companyId)).thenReturn(company);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/companies/{id}", companyId))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteById() throws Exception {
        // Mock data
        UUID companyId = UUID.randomUUID();

        // Perform the DELETE request
        mockMvc.perform(MockMvcRequestBuilders.delete("/companies/{id}", companyId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Verify the deleteById method was called
        Mockito.verify(companyCommandHandler).deleteById(companyId);
    }

    @Test
    public void testGetOfferedServicesByCompanyId() throws Exception {
        // Mock data
        UUID companyId = UUID.randomUUID();
        List<FindOfferedServiceQueryResponse> services = new ArrayList<>();
        services.add(new FindOfferedServiceQueryResponse());
        services.add(new FindOfferedServiceQueryResponse());

        // Mock behavior
        Mockito.when(offeredServiceQueryHandler.find(Mockito.any(FindCompanyOfferedServicesQuery.class))).thenReturn(services);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/companies/{companyId}/services", companyId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }
}

