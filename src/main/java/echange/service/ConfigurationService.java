/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigurationService {
    
    public Long getBalanceMinSolde(){
        return -200L;
    }
    
}
