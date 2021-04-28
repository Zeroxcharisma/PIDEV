<?php

namespace App\Form;

use App\Entity\Reclamation;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class RecType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('email')
            ->add('sujet',  ChoiceType::class, [
               
                'choices' => [
                   



                    ' très déçu par les prestations.' => ' très déçu par les prestations.',
            'manque de respect  du personnel ' => 'manque de respect  du personnel ',
            'le coach est toujour en retard ' => 'le coach est toujour en retard ',
                ] ])
            ->add('description')
            ->add('idCoach')
            ->add('idUser')
        ;
    }
  

    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults([
            'data_class' => Reclamation::class,
        ]);
    }
}
