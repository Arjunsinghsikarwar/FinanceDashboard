package com.example.FinanceDataProcessing.FinanceProject.Service.UserDetail;


import com.example.FinanceDataProcessing.FinanceProject.Model.User;
import com.example.FinanceDataProcessing.FinanceProject.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUserName(username);

        if(user==null)
            throw new UsernameNotFoundException("This UserName Does Not Exist");


        return new UserDetailInfo(user);

    }
}
