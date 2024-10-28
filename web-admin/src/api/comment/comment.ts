import instance from "../../utils/http"; 

enum API {
    GET_COMMENT_LIST = "/comment/list",
    DELETE_COMMENT_BY_ID = "/comment/{id}",
    GET_COMMENT_BY_ID = "/comment/{id}",
    UPDATE_COMMENT = "/comment/update"
}

export class CommentService {
    static async list() {
        return instance({
            url: API.GET_COMMENT_LIST,
            method: "GET"
        });
    }

    static async deleteCommentById(id: string) {
        const url = API.DELETE_COMMENT_BY_ID.replace("{id}", String(id));
        return instance({
            url,
            method: "DELETE"
        });
    }

    static async getCommentById(id: string) {
        const url = API.GET_COMMENT_BY_ID.replace("{id}", String(id));
        return instance({
            url,
            method: "GET"
        });
    }

    static async updateComment(comment: any) {
        return instance({
            url: API.UPDATE_COMMENT,
            method: "PUT",
            data: JSON.stringify(comment)
        });
    }
}