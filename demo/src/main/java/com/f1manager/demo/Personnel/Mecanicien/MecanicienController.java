package com.f1manager.demo.Personnel.Mecanicien;

import com.f1manager.demo.Personnel.pilote.Pilote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/mecano")
public class MecanicienController {

    @Autowired
    private MecanicienService mecanicienService;
    @PostMapping("/creerMecanicien/{nom}/{prenom}/{niveauActuel}/{vitesse}/{performance}/{price}")
    public ResponseEntity<Mecanicien> creerMecanicien(@PathVariable String nom, @PathVariable String prenom, @PathVariable int niveauActuel, @PathVariable double vitesse, @PathVariable double performance,@PathVariable double price, @PathVariable boolean appartient ){
        return new ResponseEntity<>(mecanicienService.creerMecanicien(nom, prenom, niveauActuel, vitesse, performance, price), HttpStatus.OK);
    }
    @GetMapping("/vitesse/{id}")
    public double getVitesseMecanicienbyId(@PathVariable int id){
       return mecanicienService.getVitesseMecanicienbyId(id);
    }

    @GetMapping("/perf/{id}")
    public double getPerformanceMecanicienbyId(@PathVariable int id){
        return mecanicienService.getPerformanceMecanicienbyId(id);
    }
    @PostMapping("/upgradeMecanicien/{idMecanicien}")
    public ResponseEntity<Mecanicien> upgradeMecanicien(@PathVariable int idMecanicien){
        return new ResponseEntity<>(mecanicienService.upgradeMecanicien(idMecanicien), HttpStatus.OK);
    }
    @GetMapping("/mecanicienCoefficientById/{idMecanicien}")
    public ResponseEntity<Double>getMecanicienCoef(@PathVariable int idMecanicien){
        return new ResponseEntity<>(mecanicienService.getMecanicienCoef(idMecanicien),HttpStatus.OK);
    }
    @PutMapping("acheterMecanicien/{idMecanicien}/{idJoueur}")
    public ResponseEntity<Double> acheterMecanicien(@PathVariable int idMecanicien, @PathVariable int idJoueur) {
        return new ResponseEntity<>(mecanicienService.buyMecanicien(idMecanicien, idJoueur), HttpStatus.OK);
    }

    @PutMapping("vendreMecanicien/{idMecanicien}/{idJoueur}")
    public ResponseEntity<Double> vendreMecanicien(@PathVariable int idMecanicien, @PathVariable int idJoueur) {
        return new ResponseEntity<>(mecanicienService.sellMecanicien(idMecanicien, idJoueur), HttpStatus.OK);
    }
    // Endpoint pour supprimer un mecanicien
    @DeleteMapping("/{id}")
    public void deleteMecanicien(@PathVariable int id) {
        mecanicienService.deleteMecanicien(id);
    }

    @GetMapping()
    public List<Mecanicien> getAllMecano() {
        List<Mecanicien> mecaniciens = mecanicienService.getAllMecano();
        for (Mecanicien mecanicien : mecaniciens) {
            System.out.println(mecanicien);
        }
        return mecaniciens;
    }
}
