import instance from "../../utils/http";

enum API {
    LIST_PRODUCTS = "/product/list",
    DELETE_PRODUCT = "/product/delete/{productId}",
    UPDATE_PRODUCT = "/product/update",
    GET_PRODUCT_BY_ID = "/product/{productId}",
    ADD_PRODUCT="/product/add"
}

export class productService{
    static async list(){
        return  instance({
            url:API.LIST_PRODUCTS,
            method:"GET",
        })
    }

    static async delete(productId: string) {
        const url = API.DELETE_PRODUCT.replace("{productId}", productId);
        return instance({
            url,
            method: "DELETE"
        });
    }

    static async update(product: any) {
        return instance({
            url: API.UPDATE_PRODUCT,
            method: "PUT",
            data: JSON.stringify(product)
        });
    }
    static async add(product: any) {
        return instance({
            url: API.ADD_PRODUCT,
            method: "POST",
            data: JSON.stringify(product)
        });
    }

    static async getById(productId: string) {
        const url = API.GET_PRODUCT_BY_ID.replace("{productId}", productId);
        return instance({
            url,
            method: "GET"
        });
    }
}