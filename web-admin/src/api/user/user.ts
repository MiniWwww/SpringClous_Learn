import instance from "../../utils/http";
import { User } from "./types";

enum API {
    LOGIN = "/user/login",
    REGISTER="/user/register",
    GET_ALL_USERS = "/user/list",
    UPDATE_USER = "/user/update",
    DELETE_USER = "/user/{id}",
    ADD_USER="/user/add"
}

export class userService {
    static async login(loginForm: object) {
        return instance({
            url: API.LOGIN,
            method: "POST",
            data: JSON.stringify(loginForm)
        });
    }

    static async register(registerform:object){
        return  instance({
            url:API.REGISTER,
            method:"POST",
            data:JSON.stringify(registerform)
        })
    }

    static async add(user: any) {
        return instance({
            url: API.ADD_USER,
            method: "POST",
            data: JSON.stringify(user)
        });
    }

    static async getAllUsers() {
        return instance({
            url: API.GET_ALL_USERS,
            method: "GET"
        });
    }

    static async updateUser(user: any) {
        return instance({
            url: API.UPDATE_USER,
            method: "PUT",
            data: JSON.stringify(user)
        });
    }

    static async deleteUserById(id: string) {
        const url = API.DELETE_USER.replace("{id}", id);
        return instance({
            url,
            method: "DELETE"
        });
    }
}