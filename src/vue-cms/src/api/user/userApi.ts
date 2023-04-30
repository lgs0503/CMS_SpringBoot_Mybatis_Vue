import axios from "axios";
import type {Login} from "@/model/user/userModel";

export const LOGIN = async (loginModel: Login) => {
     return await axios.post("http://localhost/user/login", loginModel);
}