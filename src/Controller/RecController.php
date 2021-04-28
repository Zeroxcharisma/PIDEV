<?php

namespace App\Controller;
use App\Entity\Reclamation;
use App\Entity\Utilisateur;
use App\Form\RecType;
use App\Form\ReclamationType;
use Twilio\Rest\Client;
use App\Repository\RecRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;

class RecController extends AbstractController
{
    /**
     * @Route("/rec", name="rec")
     */
    public function index(): Response
    {
        return $this->render('rec/index.html.twig', [
            'controller_name' => 'RecController',
        ]);
    }

     /**
     * @Route("/rec_Affiche", name="rec_Affiche")
     * @param RecRepository $repo
     * @return Response
     */
    function Aff(RecRepository $repo) {
        // $repo=$this->getDoctrine()->getRepository(Reclamation::class);
        $recs=$repo->findAll();
        return $this->render("rec/Aff.html.twig", ['recs'=>$recs]);
    }
      /**
     * @Route("/rec_delete/{id}", name="rec_del")
     * @param int $id
     * @return RedirectResponse
     */
    function Delete(int $id) {
        $repo=$this->getDoctrine()->getRepository(Reclamation::class);
        $entityManage=$this->getDoctrine()->getManager();
        $class=$repo->find($id);
        $entityManage->remove($class);
        $entityManage->flush();
        return $this->redirectToRoute("rec_Affiche");
    }

/**
     * @param Request $request
     * @return RedirectResponse|Response
     * @Route("/rec_up/{id}" , name="rec_up")
     */
    function UpdateR(Request $request, int $id) {
        $repo=$this->getDoctrine()->getRepository(Reclamation::class);
        $entityManage=$this->getDoctrine()->getManager();
        $oldClass=$repo->find($id);
        $form=$this->createForm(ReclamationType::class, $oldClass);
        $form->add("modifier", SubmitType::class);
        $form->handleRequest($request);
        
        if ($form->isSubmitted() && $form->isValid()) {
            $em=$this->getDoctrine()->getManager();
            $em->flush();
            return $this->redirectToRoute("rec_Affiche");
        }
        $recs = "modifier la reclamation de  ".$oldClass->getEmail();
        return $this->render("rec/addRec.html.twig", [
            'f' =>$form->createView(),
            'recs' => $recs
        ]);

    }

     /**
     * @Route("/Rec_add" , name="Rec_add")
     */
    function AjoutRec(Request $request) {
        $rec = new Reclamation();
        $form=$this->createForm(RecType::class, $rec);
        $form->add("Ajouter", SubmitType::class);
        $form->handleRequest($request);
        $rec->setEtat("non traitée");
        if ($form->isSubmitted() && $form->isValid()) {
            $coach=$this->getDoctrine()->getRepository(Reclamation::class)->findBy([
                'idCoach'=>$rec->getIdCoach()]);
                if(count($coach)>2){
          $user=$this->getDoctrine()->getRepository(Utilisateur::class)->find($rec->getIdCoach());
            $user->setEtat(false);
            $em=$this->getDoctrine()->getManager();
            $em->flush();
            $sid = "AC17b545efea0ed27b2e2d3653e5a2aa9e"; // Your Account SID from www.twilio.com/console
            $token = "f72e80921fb8bd562393d4afc5658111"; // Your Auth Token from www.twilio.com/console
    
            $client = new Client($sid, $token);
           
            $message = $client->messages->create(
    
    
                '+21650622166', // Text this number
                [
                    'from' => '+16504584051', // From a valid Twilio number
                    'body' => 'Bonjour cher coach votre compte a été bloqué à cause d un nombre de reclamation! '
                ]
            );
                }
             $em=$this->getDoctrine()->getManager();
            $em->persist($rec);
            $em->flush();
            
        
            
        }
        $title = "Ajouter reclamation ";
        
        return $this->render("rec/ajoutRec.html.twig", [
            'f' =>$form->createView(),
            'page_title' => $title
        ]);
    
        
     
   
}

    
   /**
     * @Route("/suivi", name="Rec_aff")
     * @param RecRepository $repo
     * @return Response
     */
    function Affi(RecRepository $repo) {
        // $repo=$this->getDoctrine()->getRepository(Reclamation::class);
        $user=$this->getDoctrine()->getRepository(Utilisateur::class)->find(3);
        $rec=$this->getDoctrine()->getRepository(Reclamation::class)->findBy(['idUser'=>$user->getIdUtilisateur()]);
       
        return $this->render("rec/suivi_rec.html.twig", ['rec'=>$rec]);
    }




}