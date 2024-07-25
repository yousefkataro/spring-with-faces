package io.aturanj.sales.service;

import io.aturanj.sales.model.User;

public interface UserService {
	User findUserByEmail(String email);
	void saveUser(User user);
}