package com.CrudApp.BestStore.Controller;

import ch.qos.logback.core.model.Model;
import com.CrudApp.BestStore.Model.Product;
import com.CrudApp.BestStore.Model.ProductDto;
import com.CrudApp.BestStore.Repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping

    public String showproductList;

    List<Product> Product(Model model) {
        List<Product> products = repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addattr("Product", products);
        return products;
    }

    @PostMapping("/create")
    public String showCreatePage(Model model) {
        ProductDto productDto = new ProductDto();
        return "Product/CreateProduct";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute ProductDto productDto,
            BindingResult result

    ) {
        if (productDto.getImagefile().isEmpty()) {
            result.addError(new FieldError("ProductDto", "imageFile", "The image file is required"));

        }
        if(result.hasErrors()){
            return "product/CreateProduct";
        }
        MultipartFile image=productDto.getImagefile();
        Date CreatedAt = new Date();
        String storagrFileName=createdAt.getTime()+ "_"+image.getOriginalFilename();
        try(
                String uploadDir= "public/images/";
                path uploadPath= paths.get(uploadDir);

                if(!Files.exist(uploadPath)) {
            Files.createDirectories(uploadPath);

        }
         try(InputStream inputStream=image.getInputStream()) {
             Files.copy(InputStream,paths.get(uploadDir + storagrFileName));
             StandardCopyOption.REPLACE_EXISTING
         }
         }
         catch(Exception ex){
        System.out.println("Exception:"+ex.getMessage());

    }
    return "redirect:/products";

    }




}
