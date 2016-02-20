/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core.ModelLayer;

/**
 *
 * @author andrewclawson
 */
interface IValidatable {
    
    void GetValidationErrors();
    void IsValid();
    
}
