<?php

namespace App\Controller;

use App\Entity\Utilisateur;
use App\Form\RegistrationType;



use Doctrine\Persistence\ObjectManager;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Security\Http\Authentication\AuthenticationUtils;
use Symfony\Component\Security\Core\Authentication\Token\TokenInterface;
use Symfony\Component\Security\Core\Encoder\UserPasswordEncoderInterface;

class SecurityController extends AbstractController
{

    /**
    * @Route("/inscription",name="security_registration")
    */
    public function registration(Request $request,EntityManagerInterface $manager,UserPasswordEncoderInterface $encoder,  \Swift_Mailer $mailer) {
        $Utilisateur = new Utilisateur();
     $form =$this ->createForm(RegistrationType::class, $Utilisateur);
     $form->handleRequest($request);

     if($form->isSubmitted() && $form->isValid()){
        $hash = $encoder->encodePassword($Utilisateur, $Utilisateur->getPassword());
        $Utilisateur->setPassword($hash);
         $manager->persist($Utilisateur);
         $manager->flush();

         $message= (new \Swift_Message('test'))

         ->setFrom('pidevusers@gmail.com')
         ->setTo($Utilisateur->getEmail())
         ->setSubject('Confirmation')

         ->setBody('event added!');

             $mailer->send($message);



         return $this->redirectToRoute('security_login');
     }
     return $this->render('security/registration.html.twig',[
         'form' => $form->createView()

     ]);
    }



    /**
     * @Route("/connexion",name="security_login")
     */
    public function login(AuthenticationUtils $authenticationUtils)
    {
        // get the login error if there is one
        $error = $authenticationUtils->getLastAuthenticationError();
        // last username entered by the user
        $lastUsername = $authenticationUtils->getLastUsername();

       
      // return $this->redirectToRoute('utilisateur_front_index');

        return $this->render('security/login.html.twig', ['last_username' => $lastUsername, 'error' => $error]);

        
    }

    /**
     * @Route("/erreur", name="app_erreur")
     * @param AuthenticationUtils $authenticationUtils
     * @return Response
     */
    public function erreur(AuthenticationUtils $authenticationUtils): Response
    {

        return $this->render('security/erreur.html.twig');
    }

    /**
     * @Route("/logout", name="security_logout")
     */
    public function logout()
    {
        return $this->render('security/login.html.twig');
       
    }
 
    public function onAuthenticationSuccess(Request $request, TokenInterface $token, $providerKey)
    {
        /*if ($targetPath = $this->getTargetPath($request->getSession(), $providerKey)) {
            return new RedirectResponse($targetPath);
        }*/
        // For example : return new RedirectResponse($this->urlGenerator->generate('some_route'));
        //throw new \Exception('TODO: provide a valid redirect inside '.__FILE__);
        {
            // Get list of roles for current user
            $roles = $token->getRoles();
            // Tranform this list in array
            $rolesTab = array_map(function($role){
                return $role->getRole();
            }, $roles);
            // If is a admin or super admin we redirect to the backoffice area
            if (in_array('ROLE_ADMIN', $rolesTab, true))
                $redirection = new RedirectResponse($this->urlGenerator->generate('utilisateur'));
            else
                $redirection = new RedirectResponse($this->router->generate('utilisateurFront'));

            return $redirection;
        }
    }
    
   


}
