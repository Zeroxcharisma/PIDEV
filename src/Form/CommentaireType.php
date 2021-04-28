<?php

namespace App\Form;

use App\Entity\Abonnement;
use App\Entity\Commentaire;
use App\Entity\Evenement;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\HiddenType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class CommentaireType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder

            ->add('idAb', EntityType::class, [
                'class' => Abonnement::class,
                'choice_label' => 'id'
            ])
            ->add('parentid',HiddenType::class,[
                'mapped'=>false
            ])
            ->add('Description',TextareaType::class)
            ->add('add',SubmitType::class,[
                'attr' => ['class' => 'btn'],])
        ;
    }

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Commentaire::class,
        ]);
    }
}
