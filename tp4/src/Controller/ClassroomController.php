<?php

namespace App\Controller;

use App\Entity\Classroom;
use App\Repository\ClassroomRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class ClassroomController extends AbstractController
{
    /**
     * @Route("/classroom", name="classroom")
     */
    public function index(): Response
    {
        return $this->render('classroom/index.html.twig', [
            'controller_name' => 'ClassroomController',
        ]);
    }


    /**
     * @Route("/classroom/Affiche", name="afficheclass")
     */
    public function Affiche(ClassroomRepository $repository)  {
       // $repository=$this->getRepository(Classroom::class);
        $classroom=$repository->findAll();
        return $this->render('classroom/affiche.html.twig',
            ['classroom'=>$classroom]);

    }
   /* public function affiche(){
        $repository=$this->getRepository(classroom::class);
        $classroom=$repository->findAll();
        return $this->render('classroom/affiche.html.twig',
        ['classroom'=>$classroom]);
    }

    // suppression d'une ligne du tableau classroom
    /**
     * @Route ("/del/{id}",name="delete")
     */
    
    public function Delete($id,ClassroomRepository $repository){
        $classroom=$repository->find($id);
        $del=$this->getDoctrine()->getManager();
        $del->remove($classroom);
        $del->flush();
        return $this->redirectToRoute("afficheclass");
    }
}

