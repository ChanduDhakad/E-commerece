package com.shop.service;

import com.shop.exception.*;
import com.shop.model.Category;


public interface CategoryService {

	Category addCategory(Category category,String adminKey) throws LoginException,CategoryException,AdminException ;
}
