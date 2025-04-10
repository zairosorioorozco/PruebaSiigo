package com.qastaging.siigo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.*;

public class CreateClienteUserInterface {

    public static final String SHADOW_CREATE_BUTTON = "siigo-header-molecule[class='data-siigo-five9 hydrated']";
    public static final String CREATE_BUTTON = "siigo-button-atom[data-id='header-create-button']";
    public static final String CLIENTE_BUTTON = "a[data-value='Clientes']";
    public static final String SHADOW_TYPE_SELECT = "siigo-dropdownlist-web[state='0']";
    public static final Target SELECT_PERSON_TYPE = the("Type person ").locatedBy("//li[contains(text(),'{0}')]");
    public static final String TYPE_SELECT = "div > div > div.mdc-select__anchor.mdc-ripple-upgraded";
    public static final String SHADOW_TYPE_IDENTIFY = "siigo-dropdownlist-web[state='75']";
    public static final String SELECT_TYPE = "div > div > div.mdc-select__anchor.mdc-ripple-upgraded";
    public static final Target SELECT_LIST_TYPE = the("tYpe Identification ").locatedBy("//li[contains(text(),'{0}')]");
    public static final String SHADOW_INPUT_IDENTIFICATION = "siigo-identification-input-web[class='hydrated']";
    public static final String INPUT_IDENTIFICATION = "input[class='mdc-text-field__input input-identification']";
    public static final String SHADOW_NAME = "div > div > div:nth-child(1) > div.column.is-7 > div:nth-child(1) > siigo-textfield-web";
    public static final String SHADOW_LAST_NAME = "div > div > div:nth-child(1) > div.column.is-7 > div:nth-child(2) > siigo-textfield-web";
    public static final String INPUT_NAME = "input[aria-describedby='my-helper-id']";
    public static final String LABEL_CITY = "span[id='spanAutocompletecity']";
    public static final String SHADOW_CITY = "div > div > div:nth-child(1) > div.column.is-7 > div:nth-child(5) > siigo-autocomplete-web";
    public static final String INPUT_CITY = "input[name='inputAutocompletecity']";
    public static final String SELECT_AUTO_COMPLETE = "div[id='divTDAutocompletecity1']";
    public static final String SAVE_BUTTON = "#sticky > div.column.title-right > button.button.green.filled";
    public static final Target CONFIRMATION_CREATE_CLIENTE = the("label confirmation").locatedBy("//*[contains(text(),'Tercero guardado exitosamente')]");




}
