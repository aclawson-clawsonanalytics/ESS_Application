/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clawsonanalytics.ESS.App.ModelLayer.Interface;

import com.clawsonanalytics.ESS.App.DataLayer.MySQL.Interface.SQLModel;/**
 *
 * @author andrewclawson
 */
public interface IModelSetManager {
    void LoadSet();
    
    void NotifyDataChange();
}
