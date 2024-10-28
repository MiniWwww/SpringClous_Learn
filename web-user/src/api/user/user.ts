import instance from "../../utils/http";
import {User} from "./types";

enum API {
    LOGIN = "/user/login",
    REGISTER = "/user/register",
    GET_ALL_USERS="/user/getAllUsers",
    BAND_USER_BY_ID="/user/bandUserById",
    UPDATE_USER="/user/updateUser"

}

export  class userService{
    static async login(loginForm:object){
        return  instance({
            url:API.LOGIN,
            method:"POST",
            data:JSON.stringify(loginForm)
        })
    }

    static async register(registerform:object){
        return  instance({
            url:API.REGISTER,
            method:"POST",
            data:JSON.stringify(registerform)
        })
    }

    static async getAllUsers(){
        return  instance({
            url:API.GET_ALL_USERS,
            method:"GET",
        })
    }

    static async bandUserById(id:string,status:boolean){
        return  instance({
            url:API.BAND_USER_BY_ID+`/${id}/${status}`,
            method:"put",
        })
    }

    static async updateUser(user:User){
        return  instance({
            url:API.UPDATE_USER,
            method:"POST",
            data:JSON.stringify(user)
        })
    }


}