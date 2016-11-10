package ik.am.jpetstore.domain.service.account;

import ik.am.jpetstore.domain.model.Account;
import ik.am.jpetstore.domain.repository.account.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AccountServiceImplTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void should_get_account_when_given_username() throws Exception {

        String username = "username";
        Account dummy = new Account();

        when(accountRepository.getAccountByUsername(username)).thenReturn(dummy);

        accountService.getAccount(username);

        verify(accountRepository, times(1)).getAccountByUsername(username);
    }
}